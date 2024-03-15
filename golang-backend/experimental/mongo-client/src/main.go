package main

import (
	"context"
	"fmt"
	"log"
	"time"

	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
)

type Person struct {
	Name  string
	Age   int
	Email string
}

func main() {
	clientOption := options.Client().ApplyURI("mongodb://localhost:19000")
	ctx, cancel := context.WithTimeout(context.Background(), time.Second*10)
	defer cancel()

	client, err := mongo.Connect(ctx, clientOption)

	if err != nil {
		log.Fatal(err)
	}

	defer func() {
		if err = client.Disconnect(ctx); err != nil {
			panic(err)
		}
	}()

	collection := client.Database("test").Collection("people")
	person := Person{Name: "John", Age: 30, Email: "john@example.com"}

	res, err := collection.InsertOne(ctx, person)

	fmt.Printf("Inserted document: %v \r\n", res)

	result := Person{}

	filter := bson.D{{"name", "John"}}

	err = collection.FindOne(ctx, filter).Decode(&result)

	fmt.Printf("Error: %v \r\n", err)

	fmt.Printf("Value: %v \r\n", result)
}
