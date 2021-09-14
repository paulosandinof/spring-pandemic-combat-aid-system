The following table was created to help with tests

| ID  	                                | NAME  	    | VALUE |
|---------------------------------------|-------------|-------|  
| 0ca7f082-1eee-48d1-aa11-8594156468e1  | Médico      | 3     |
| 30ee7abf-0106-4f32-8cc2-550b94bc99f9  | Enfermeiro	| 3     |
| 61543f47-75a9-4e39-8d04-fa35b75835cf  | Respirador	| 5     |
| f67abdb2-e291-4b79-99f3-3d191cac5fc1  | Tomógrafo	  | 12    |
| 0a0a6603-c83b-45a4-9d38-3cff1a9bff5e  | Ambulância	| 10    |

## POST /hospitals

| Parameter                 | Description
|-------------------------  |-----------------------------------------------|
|   name                    | The name of the hospital                      |
|   address                 | The address of the hospital                   |
|   cnpj                    | The cnpj of the hospital                      |
|   latitude                | The latitude of the hospital                  |
|   longitude               | The longitude of the hospital                 |
|   occupationPercentage    | The occupation percentage of the hospital     |
|   resources               | An array of resources                         |
|   resource.name           | The name of the resource                      |
|   resource.type           | The id of a previously registered resou type  |

### Request Example
```json
{
	"name": "Hospital 1",
	"address": "Rua Chile",
	"cnpj": "123456789",
	"latitude": "40.0000",
	"longitude": "12.0000",
	"occupationPercentage": "40.0",
	"resources": [
		{
			"name": "José Souza",
			"type": "0ca7f082-1eee-48d1-aa11-8594156468e1"
		},
		{
			"name": "RX-2000",
			"type": "f67abdb2-e291-4b79-99f3-3d191cac5fc1"
		}
	]
}
```

### Response Example
```json
{
  "id": "c9bedc37-40a5-4256-b020-7a2e716f8cac",
  "name": "Hospital 1",
  "address": "Rua Chile",
  "cnpj": "123456789",
  "latitude": 40.0,
  "longitude": 12.0,
  "occupationPercentage": 40.0,
  "resources": [
    {
      "id": "51233e67-4f6b-45b8-ad24-d34b6cf55232",
      "name": "José Souza",
      "resourceType": {
        "id": "0ca7f082-1eee-48d1-aa11-8594156468e1",
        "name": "Médico",
        "value": 3
      }
    },
    {
      "id": "f336cd81-8668-472b-b68b-9c43fc312219",
      "name": "RX-2000",
      "resourceType": {
        "id": "f67abdb2-e291-4b79-99f3-3d191cac5fc1",
        "name": "Tomógrafo",
        "value": 12
      }
    }
  ]
}
```