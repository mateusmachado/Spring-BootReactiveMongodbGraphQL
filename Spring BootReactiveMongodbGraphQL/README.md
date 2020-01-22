# spring-boot-graphql

## Run MongoDB 
`docker run -d -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=admin mongo`

## GraphQL Client

`http://localhost:8080/graphiql`

### Example
- Simple Query:
```
query {
  findAllPrice {
    productId
    loc
    productGrandId
    regularRetail
    unitRetail
    sellingUnitRetail
    clearanceInd
    sku
  }
}
```
- Query with Query Variables:

```
query {
  findPriceByProductId(productId: $productId) {
    productId
    loc
    productGrandId
    regularRetail
    unitRetail
    sellingUnitRetail
    clearanceInd
    sku
    creationDate
  }
}


query {
  countPrice
}
```
- Mutation
```
mutation {
  newPrice(
        productId: "001"
        loc: 1,
        productGrandId: 1,
        regularRetail: 1,
        unitRetail: 1,
        sellingUnitRetail: 1,
        clearanceInd: true,
        sku: 1) {  
    productId
  }
}
```

## Graphql Subscription page

`http://localhost:8080/index.html`

## Notes

To use subscriptions with Reactive MongoDB the Price collection must be capped.

```shell
mongo

use price

db.price.insert({"productId":"1", "loc": 1, "productGrandId": 1, "regularRetail": 1, "unitRetail": 1, "sellingUnitRetail": 1,
    "clearanceInd": true, "sku": 1, "creationDate": "2020-01-21"
})

db.price.find()
```