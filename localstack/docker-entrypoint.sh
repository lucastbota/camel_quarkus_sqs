#!/bin/bash
aws configure set aws_access_key_id key
aws configure set aws_secret_access_key secret101
aws configure set region sa-east-1
aws configure set output table
## Create sns
aws --endpoint-url=http://localhost:4566 sns create-topic --name credit-topic
## Create sqs
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name company-one-queue
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name company-two-queue

sleep 5
echo 'Subscribing'
## Subscribing
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:credit-topic --protocol sqs --notification-endpoint arn:aws:sqs:sa-east-1:000000000000:company-one-queue  --attributes "{\"RawMessageDelivery\": \"true\", \"FilterPolicy\": \"{\\\"company\\\": [\\\"O\\\"]}\"}"
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:credit-topic --protocol sqs --notification-endpoint arn:aws:sqs:sa-east-1:000000000000:company-two-queue  --attributes "{\"RawMessageDelivery\": \"true\", \"FilterPolicy\": \"{\\\"company\\\": [\\\"T\\\"]}\"}"

aws --endpoint-url=http://localhost:4566 sns list-subscriptions