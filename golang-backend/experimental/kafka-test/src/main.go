package main

import (
	"fmt"
	"time"

	"github.com/confluentinc/confluent-kafka-go/v2/kafka"
)

func main() {
	consumer, err := kafka.NewConsumer(&kafka.ConfigMap{
		"bootstrap.servers": "localhost:29092",
		"group.id":          "myGroup",
		"auto.offset.reset": "earliest",
		"security.protocol": "PLAINTEXT",
	})

	if err != nil {
		panic(err)
	}

	fmt.Println("init consumer")

	consumer.SubscribeTopics([]string{"myTopic", "test-topic"}, nil)

	fmt.Println("subscription for topics")

	run := true

	for run {
		msg, err := consumer.ReadMessage(time.Second)
		if err == nil {
			fmt.Printf("Message on %s: %s\n", msg.TopicPartition, string(msg.Value))
		} else if !err.(kafka.Error).IsTimeout() {
			fmt.Printf("Consumer error: %v %v \r\n", err, msg)
		}
	}

	consumer.Close()
}
