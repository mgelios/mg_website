package main

import (
	"fmt"

	"github.com/gocql/gocql"
)

func main() {
	cluster := gocql.NewCluster("localhost:14000")
	cluster.Keyspace = "my_keyspace"
	cluster.Consistency = gocql.Quorum

	session, err := cluster.CreateSession()

	if err != nil {
		fmt.Println("Error connecting to Cassandra:", err)
		return
	}

	defer session.Close()

	if err := session.Query("INSERT INTO my_table (id, name, age) VALUES (?, ?, ?)", "Some id", "John Doe", 30).Exec(); err != nil {
		fmt.Println("Error inserting record:", err)
		return
	}

	scanner := session.Query("SELECT id, name, age FROM my_table").Iter().Scanner()

	var id string
	var name string
	var age int

	for scanner.Next() {
		err := scanner.Scan(&id, &name, &age)
		if err != nil {
			fmt.Println("Error executing query", err)
			return
		}
	}

	fmt.Println("Row in the table:", id, name, age)
}
