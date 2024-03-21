package cache

import (
	"cache-aside-redis-mongo/model"
	"context"

	"github.com/redis/go-redis/v9"
)

type cacheClient interface {
	getRecordFromCache(key string) string
}

type redisCache struct {
	client  *redis.Client
	context context.Context
}

var redisCacheInstance redisCache

func init() {
	ctx := context.Background()
	client := redis.NewClient(&redis.Options{
		Addr:     "localhost:18000",
		Password: "",
		DB:       0,
	})

	redisCacheInstance.client = client
	redisCacheInstance.context = ctx

}

func (client *redisCache) getRecordFromCache(key string) string {

	result := client.client.Get(client.context, key)
	return result.Val()
}

func putRecordIntoCache(key string, item model.Item) {

}
