## add products

```bash

curl -X POST http://localhost:8088/products \
-H "Content-Type: application/json" \
-d '{
"id": null,
"description": "Sample Product2",
"price": 18.99,
"quantityAvailable": 101
}'

```


## add products

```bash
curl -X GET http://localhost:8088/product/1
```

```bash
curl -X GET http://localhost:8080/product/2
```