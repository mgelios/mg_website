package cache

import (
	"context"

	"github.com/redis/go-redis/v9"
)

func getRecordFromCache(key string) string {
	ctx := context.Background()

	client := redis.NewClient(&redis.Options{
		Addr:     "localhost:18000",
		Password: "",
		DB:       0,
	})

	result := client.Get(ctx, key)

	return result.Val()
}
