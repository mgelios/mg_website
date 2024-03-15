package main

import (
	"context"
	"fmt"
	"os"

	"github.com/jackc/pgx/v5"
)

func main() {

	conn, err := pgx.Connect(context.Background(), "postgres://my_user:my_password@localhost:15000/my_database")

	if err != nil {
		fmt.Printf("Error occured %v\r\n", err)
	}

	defer conn.Close(context.Background())

	var greeting string

	err = conn.QueryRow(context.Background(), "select 'Hello world'").Scan(&greeting)

	if err != nil {
		fmt.Printf("Query failed: %v", err)
		os.Exit(1)
	}

	fmt.Println(greeting)
}
