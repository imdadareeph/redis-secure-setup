## add products

```bash

curl -X POST http://localhost:8080/products \
-H "Content-Type: application/json" \
-d '{
"id": null,
"description": "Sample Product",
"price": 19.99,
"quantityAvailable": 100
}'

```


## add products

```bash
curl -X GET http://localhost:8080/product/1
```

```bash
curl -X GET http://localhost:8080/product/2
```