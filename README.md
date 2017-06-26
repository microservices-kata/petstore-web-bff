# petstore-web-bff

|method|url|desc|
|:---|:---|:---|
|GET |http://localhost:8090/swagger-ui.html|API List|
|GET |http://localhost:8090/health|Health check|
|GET |http://localhost:8090/app/info|Show app info|
|POST|http://localhost:8090/users/register|Register user|
|POST|http://localhost:8090/users/login|User login|
|GET |http://localhost:8090/users/info|Get user info|
|PUT |http://localhost:8090/users/info|Update user info|
|GET |http://localhost:8090/pets/categories/list|Get category list|
|GET |http://localhost:8090/pets/species/list?category={id}|Get species list|
|GET |http://localhost:8090/pets/list?species={id}|Get pet list|
|GET |http://localhost:8090/pets/detail?id={id}|Get pet detail|
|POST|http://localhost:8090/pets/buy|Buy a pet|
|GET |http://localhost:8090/orders/list|Get order list|
|GET |http://localhost:8090/orders/detail?id={id}|Get order detail|
|POST|http://localhost:8090/orders/refund|Refund a order|

