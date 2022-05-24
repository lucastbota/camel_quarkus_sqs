## Create sns
aws --endpoint-url=http://localhost:4566 sns create-topic --name credit-topic
## Create sqs
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name company-one-queue
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name company-two-queue

## Subscribing
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:credit-topic --protocol sqs --notification-endpoint http://localhost:4566/000000000000/company-one-queue --attributes "{\"RawMessageDelivery\": \"true\", \"FilterPolicy\": \"{\\\"company\\\": [\\\"O\\\"]}\"}"
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:sa-east-1:000000000000:credit-topic --protocol sqs --notification-endpoint http://localhost:4566/000000000000/company-two-queue --attributes "{\"RawMessageDelivery\": \"true\", \"FilterPolicy\": \"{\\\"company\\\": [\\\"T\\\"]}\"}"

aws --endpoint-url=http://localhost:4566 sns list-subscriptions