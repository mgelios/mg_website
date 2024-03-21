package db

import (
	"cache-aside-redis-mongo/model"
	"context"
	"fmt"
	"log"
	"time"

	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

type DBConnection interface {
	putRecordIntoDB(item *model.Item) error
	getRecordFromDBByName(name string) error
}

type dbClient struct {
	context    context.Context
	connection *mongo.Client
	collection *mongo.Collection
}

var mongoClient dbClient

func init() {
	clientOption := options.Client().ApplyURI("mongodb://localhost:19000")
	ctx, cancel := context.WithTimeout(context.Background(), time.Second*10)
	defer cancel()

	connection, err := mongo.Connect(ctx, clientOption)

	if err != nil {
		log.Fatal(err)
	}

	mongoClient.connection = connection
	mongoClient.context = ctx

	// defer func() {
	// 	if err = connection.Disconnect(ctx); err != nil {
	// 		panic(err)
	// 	}
	// }()
}

func (client *dbClient) putRecordIntoDB(item *model.Item) {
	collection := client.connection.Database("test").Collection("people")
	res, err := collection.InsertOne(client.context, item)

	if err != nil {
		log.Fatal(err)
	}

	client.collection = collection

	fmt.Printf("Inserted document: %v \r\n", res)
}

func (client *dbClient) getRecordFromDBByName(name string) {
	result := model.Item{}
	filter := bson.D{{"name", name}}
	err := client.collection.FindOne(client.context, filter).Decode(&result)
	fmt.Printf("Error: %v \r\n", err)
	fmt.Printf("Value: %v \r\n", result)
}
