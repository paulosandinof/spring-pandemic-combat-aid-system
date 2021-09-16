# Spring Pandemic Combat Aid System

## Description

Project of a Rest API to register hospital, resources and allow exchanging of resources between them.

This project was made using Java 11 and Spring Boot 2.5.4. The system is using a file database for storing the data. After running the application you can check the url http://localhost:8080/h2-console to see the database tables. The credentials are the same in the _application.yml_ file. There's some dummy data on the database that can be used to test most of the endpoints.

## Features

- Add Hospitals: A hospital must de added with it's respective resources. The resources must be of a previously registered type. The following table was created to represent the resource and how much it is worth in a exchange.

  | ID                                   | NAME       | VALUE |
  | ------------------------------------ | ---------- | ----- |
  | 37ac2236-6c2d-4661-9db7-d279d956985a | Médico     | 3     |
  | fa40bc44-c683-4273-af38-7790b0cd5a5d | Enfermeiro | 3     |
  | 009c05cc-0039-42f6-8e30-780ed2cface2 | Respirador | 5     |
  | 5e035dbf-01f7-4b89-8cf9-315cc08e8576 | Tomógrafo  | 12    |
  | 4d8af97f-c275-415e-9431-b356c543f98d | Ambulância | 10    |

  In the future is possible to create another endpoint to create different types.

- Update the occupation percentage of a hospital: A hospital can have its occupation percentage updated anytime.

- Hospitals cannot add or remove resources: A hospital can only add resources during its creation, and it is not possible to remove resources. The only way possible for change a resource is through an exchange.

- Resources exchange: Two hospitals can exchange resources, but the value of the offered resources by both of them must be equivalent. If a hospital is overcrowded, it can offer less resources than the other hospital.

- Reports: A report can be generated containing:
  - Percentage of hospitals with occupation over 90%
  - Percentage of hospitals with occupation under or equal to 90%
  - Average quantity of resources types by hospital
  - Hospital with occupation over 90% for longer
  - Hospital with occupation under or equal 90% for longer
  - Exchanges history

## Running the application
```bash
mvn spring-boot:run
```

# Endpoints

## GET /hospitals

### Response Example

```json
[
  {
    "id": "b3aa3a67-12e2-47a7-a17b-9f963fff856a",
    "name": "Hospital Walfredo Gurgel",
    "address": "Rua Mossoró, 8945",
    "cnpj": "9876543210",
    "latitude": 80.0,
    "longitude": 32.0,
    "occupationPercentage": 50.0,
    "occupationUpdatedAt": "2021-09-16T11:00:44.680174",
    "resources": [
      {
        "id": "cdbcff7f-f2cf-4dfe-b0b6-3c9e95f2367a",
        "name": "Dra. Maria de Fátima",
        "resourceType": {
          "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
          "name": "Médico",
          "value": 3,
          "createdAt": "2021-09-16T10:51:38.616521",
          "updatedAt": "2021-09-16T10:51:38.616557"
        },
        "createdAt": "2021-09-16T11:00:44.708875",
        "updatedAt": "2021-09-16T11:00:44.708894"
      },
      {
        "id": "adbfc547-c67d-499a-8edd-c82ddc0f8af3",
        "name": "Respirador 1",
        "resourceType": {
          "id": "009c05cc-0039-42f6-8e30-780ed2cface2",
          "name": "Respirador",
          "value": 5,
          "createdAt": "2021-09-16T10:51:38.624513",
          "updatedAt": "2021-09-16T10:51:38.624523"
        },
        "createdAt": "2021-09-16T11:00:44.710967",
        "updatedAt": "2021-09-16T11:00:44.710978"
      }
    ],
    "createdAt": "2021-09-16T11:00:44.708105",
    "updatedAt": "2021-09-16T11:00:44.708129"
  },
  {
    "id": "fece39b8-5246-48a0-9475-686c0cbe8529",
    "name": "Hospital Varela Santiago",
    "address": "Rua Apodi, 2302",
    "cnpj": "123456789",
    "latitude": 40.0,
    "longitude": 12.0,
    "occupationPercentage": 55.0,
    "occupationUpdatedAt": "2021-09-16T11:06:31.370217",
    "resources": [
      {
        "id": "98f56646-5492-4bd8-919f-bfefa484bf7b",
        "name": "Dra. Luiza Maia",
        "resourceType": {
          "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
          "name": "Médico",
          "value": 3,
          "createdAt": "2021-09-16T10:51:38.616521",
          "updatedAt": "2021-09-16T10:51:38.616557"
        },
        "createdAt": "2021-09-16T11:06:31.379492",
        "updatedAt": "2021-09-16T11:06:31.379513"
      },
      {
        "id": "ec31039a-a65e-4f6a-a400-6f4d41eebb49",
        "name": "Marcos Rogério",
        "resourceType": {
          "id": "fa40bc44-c683-4273-af38-7790b0cd5a5d",
          "name": "Enfermeiro",
          "value": 3,
          "createdAt": "2021-09-16T10:51:38.623808",
          "updatedAt": "2021-09-16T10:51:38.623826"
        },
        "createdAt": "2021-09-16T11:06:31.380877",
        "updatedAt": "2021-09-16T11:06:31.380898"
      }
    ],
    "createdAt": "2021-09-16T11:06:31.37793",
    "updatedAt": "2021-09-16T11:06:31.37796"
  }
]
```

## POST /hospitals

| Parameter            | Description                                     |
| -------------------- | ----------------------------------------------- |
| name                 | The name of the hospital                        |
| address              | The address of the hospital                     |
| cnpj                 | The cnpj of the hospital                        |
| latitude             | The latitude of the hospital                    |
| longitude            | The longitude of the hospital                   |
| occupationPercentage | The occupation percentage of the hospital       |
| resources            | An array of resources                           |
| resource.name        | The name of the resource                        |
| resource.type        | The id of a previously registered resource type |

### Request Example

```json
{
  "name": "Hospital Walfredo Gurgel",
  "address": "Rua Mossoró, 8945",
  "cnpj": "9876543210",
  "latitude": "80.0000",
  "longitude": "32.0000",
  "occupationPercentage": "50.0",
  "resources": [
    {
      "name": "Dra. Maria de Fátima",
      "type": "37ac2236-6c2d-4661-9db7-d279d956985a"
    },
    {
      "name": "Tomógrafo 32 Canais",
      "type": "5e035dbf-01f7-4b89-8cf9-315cc08e8576"
    }
  ]
}
```

### Response Example

```json
{
  "id": "b3aa3a67-12e2-47a7-a17b-9f963fff856a",
  "name": "Hospital Walfredo Gurgel",
  "address": "Rua Mossoró, 8945",
  "cnpj": "9876543210",
  "latitude": 80.0,
  "longitude": 32.0,
  "occupationPercentage": 50.0,
  "occupationUpdatedAt": "2021-09-16T11:00:44.680174",
  "resources": [
    {
      "id": "cdbcff7f-f2cf-4dfe-b0b6-3c9e95f2367a",
      "name": "Dra. Maria de Fátima",
      "resourceType": {
        "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
        "name": "Médico",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.616521",
        "updatedAt": "2021-09-16T10:51:38.616557"
      },
      "createdAt": "2021-09-16T11:00:44.708875",
      "updatedAt": "2021-09-16T11:00:44.708894"
    },
    {
      "id": "33581183-6333-4e6f-9fdd-395826c2f691",
      "name": "Tomógrafo 32 Canais",
      "resourceType": {
        "id": "5e035dbf-01f7-4b89-8cf9-315cc08e8576",
        "name": "Tomógrafo",
        "value": 12,
        "createdAt": "2021-09-16T10:51:38.625124",
        "updatedAt": "2021-09-16T10:51:38.625134"
      },
      "createdAt": "2021-09-16T11:00:44.71169",
      "updatedAt": "2021-09-16T11:00:44.7117"
    }
  ],
  "createdAt": "2021-09-16T11:00:44.708105",
  "updatedAt": "2021-09-16T11:00:44.708129"
}
```

## GET /hospitals/{hospitalId}

| Parameter  | Description                                |
| ---------- | ------------------------------------------ |
| hospitalId | The id of a previously registered hospital |

### Reponse Example

```json
{
  "id": "589fc789-7dda-427b-92ae-1556c40ff952",
  "name": "Hospital Giselda Trigueiro",
  "address": "Rua Marcelino Vieira, 845",
  "cnpj": "4567891230",
  "latitude": 89.0,
  "longitude": 45.0,
  "occupationPercentage": 55.0,
  "occupationUpdatedAt": "2021-09-16T11:09:40.594853",
  "resources": [
    {
      "id": "57f35ab8-eef0-4160-b3d4-f1c38df39527",
      "name": "Dra. Francisca Pereira",
      "resourceType": {
        "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
        "name": "Médico",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.616521",
        "updatedAt": "2021-09-16T10:51:38.616557"
      },
      "createdAt": "2021-09-16T11:09:40.600508",
      "updatedAt": "2021-09-16T11:09:40.600524"
    },
    {
      "id": "e67b01b9-4753-4c36-a876-7c9cdce90609",
      "name": "Marcos Rogério",
      "resourceType": {
        "id": "fa40bc44-c683-4273-af38-7790b0cd5a5d",
        "name": "Enfermeiro",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.623808",
        "updatedAt": "2021-09-16T10:51:38.623826"
      },
      "createdAt": "2021-09-16T11:09:40.600898",
      "updatedAt": "2021-09-16T11:09:40.600914"
    }
  ],
  "createdAt": "2021-09-16T11:09:40.600005",
  "updatedAt": "2021-09-16T11:09:40.600024"
}
```

## PATCH /hospitals/{hospitalId}

| Parameter            | Description                                                        |
| -------------------- | ------------------------------------------------------------------ |
| hospitalId           | The id of a previously registered hospital                         |
| occupationPercentage | The new occupation percentage for a previously registered hospital |

### Request Example

```json
{
  "occupationPercentage": "90.0"
}
```

### Response Example

```json
{
  "id": "589fc789-7dda-427b-92ae-1556c40ff952",
  "name": "Hospital Giselda Trigueiro",
  "address": "Rua Marcelino Vieira, 845",
  "cnpj": "4567891230",
  "latitude": 89.0,
  "longitude": 45.0,
  "occupationPercentage": 90.0,
  "occupationUpdatedAt": "2021-09-16T11:09:40.594853",
  "resources": [
    {
      "id": "57f35ab8-eef0-4160-b3d4-f1c38df39527",
      "name": "Dra. Francisca Pereira",
      "resourceType": {
        "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
        "name": "Médico",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.616521",
        "updatedAt": "2021-09-16T10:51:38.616557"
      },
      "createdAt": "2021-09-16T11:09:40.600508",
      "updatedAt": "2021-09-16T11:09:40.600524"
    },
    {
      "id": "e67b01b9-4753-4c36-a876-7c9cdce90609",
      "name": "Marcos Rogério",
      "resourceType": {
        "id": "fa40bc44-c683-4273-af38-7790b0cd5a5d",
        "name": "Enfermeiro",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.623808",
        "updatedAt": "2021-09-16T10:51:38.623826"
      },
      "createdAt": "2021-09-16T11:09:40.600898",
      "updatedAt": "2021-09-16T11:09:40.600914"
    }
  ],
  "createdAt": "2021-09-16T11:09:40.600005",
  "updatedAt": "2021-09-16T11:09:40.600024"
}
```

## POST /exchanges

| Parameter                 | Description                                             |
| ------------------------- | ------------------------------------------------------- |
| firstHospital.hospitalId  | The id of a previously registered hospital              |
| firstHospital.resources   | The ids of firstHospital's resources proposed to trade  |
| secondHospital.hospitalId | The id of a previously registered hospital              |
| secondHospital.resources  | The ids of secondHospital's resources proposed to trade |

### Request Exameple

```json
{
  "firstHospital": {
    "hospitalId": "b3aa3a67-12e2-47a7-a17b-9f963fff856a",
    "resources": [
      "cdbcff7f-f2cf-4dfe-b0b6-3c9e95f2367a",
      "c578fd1c-2dd3-4a6b-ac76-a12c589ea4b9"
    ]
  },
  "secondHospital": {
    "hospitalId": "589fc789-7dda-427b-92ae-1556c40ff952",
    "resources": []
  }
}
```

## GET /reports

### Response Example

```json
{
  "hospitalsOvercrowdedPercentage": 33.0,
  "hospitalsUndercrowdedPercentage": 66.0,
  "longerOvercrowdedHospital": {
    "id": "589fc789-7dda-427b-92ae-1556c40ff952",
    "name": "Hospital Giselda Trigueiro",
    "address": "Rua Marcelino Vieira, 845",
    "cnpj": "4567891230",
    "latitude": 89.0,
    "longitude": 45.0,
    "occupationPercentage": 90.1,
    "occupationUpdatedAt": "2021-09-16T11:45:24.439546",
    "resources": [...],
    "createdAt": "2021-09-16T11:09:40.600005",
    "updatedAt": "2021-09-16T11:45:24.439875"
  },
  "longerUndercrowdedHospital": {
    "id": "b3aa3a67-12e2-47a7-a17b-9f963fff856a",
    "name": "Hospital Walfredo Gurgel",
    "address": "Rua Mossoró, 8945",
    "cnpj": "9876543210",
    "latitude": 80.0,
    "longitude": 32.0,
    "occupationPercentage": 50.0,
    "occupationUpdatedAt": "2021-09-16T11:00:44.680174",
    "resources": [...],
    "createdAt": "2021-09-16T11:00:44.708105",
    "updatedAt": "2021-09-16T11:00:44.708129"
  },
  "averageResourceTypes": [
    {
      "resourceType": {
        "id": "fa40bc44-c683-4273-af38-7790b0cd5a5d",
        "name": "Enfermeiro",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.623808",
        "updatedAt": "2021-09-16T10:51:38.623826"
      },
      "averageQuantity": 1.6666666666666667
    },
    {
      "resourceType": {
        "id": "4d8af97f-c275-415e-9431-b356c543f98d",
        "name": "Ambulância",
        "value": 10,
        "createdAt": "2021-09-16T10:51:38.625697",
        "updatedAt": "2021-09-16T10:51:38.625706"
      },
      "averageQuantity": 1.3333333333333333
    },
    {
      "resourceType": {
        "id": "5e035dbf-01f7-4b89-8cf9-315cc08e8576",
        "name": "Tomógrafo",
        "value": 12,
        "createdAt": "2021-09-16T10:51:38.625124",
        "updatedAt": "2021-09-16T10:51:38.625134"
      },
      "averageQuantity": 1.0
    },
    {
      "resourceType": {
        "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
        "name": "Médico",
        "value": 3,
        "createdAt": "2021-09-16T10:51:38.616521",
        "updatedAt": "2021-09-16T10:51:38.616557"
      },
      "averageQuantity": 2.6666666666666665
    },
    {
      "resourceType": {
        "id": "009c05cc-0039-42f6-8e30-780ed2cface2",
        "name": "Respirador",
        "value": 5,
        "createdAt": "2021-09-16T10:51:38.624513",
        "updatedAt": "2021-09-16T10:51:38.624523"
      },
      "averageQuantity": 2.0
    }
  ],
  "exchangeHistory": [
    {
      "id": "213432bd-8145-4677-96dc-2a07a7e90bcc",
      "sender": {
        "id": "b3aa3a67-12e2-47a7-a17b-9f963fff856a",
        "name": "Hospital Walfredo Gurgel",
        "address": "Rua Mossoró, 8945",
        "cnpj": "9876543210",
        "latitude": 80.0,
        "longitude": 32.0,
        "occupationPercentage": 50.0,
        "occupationUpdatedAt": "2021-09-16T11:00:44.680174",
        "resources": [...],
        "createdAt": "2021-09-16T11:00:44.708105",
        "updatedAt": "2021-09-16T11:00:44.708129"
      },
      "receiver": {
        "id": "589fc789-7dda-427b-92ae-1556c40ff952",
        "name": "Hospital Giselda Trigueiro",
        "address": "Rua Marcelino Vieira, 845",
        "cnpj": "4567891230",
        "latitude": 89.0,
        "longitude": 45.0,
        "occupationPercentage": 90.1,
        "occupationUpdatedAt": "2021-09-16T11:45:24.439546",
        "resources": [...],
        "createdAt": "2021-09-16T11:09:40.600005",
        "updatedAt": "2021-09-16T11:45:24.439875"
      },
      "exchangeResources": [
        {
          "id": "3145b1b8-c8c3-4dff-848b-aa15a0bfd192",
          "resource": {
            "id": "cdbcff7f-f2cf-4dfe-b0b6-3c9e95f2367a",
            "name": "Dra. Maria de Fátima",
            "resourceType": {
              "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
              "name": "Médico",
              "value": 3,
              "createdAt": "2021-09-16T10:51:38.616521",
              "updatedAt": "2021-09-16T10:51:38.616557"
            },
            "createdAt": "2021-09-16T11:00:44.708875",
            "updatedAt": "2021-09-16T11:47:56.640482"
          },
          "createdAt": "2021-09-16T11:47:56.639917",
          "updatedAt": "2021-09-16T11:47:56.639932"
        },
        {
          "id": "919f92d7-33ea-4fa5-b5ff-3b88e016d94f",
          "resource": {
            "id": "c578fd1c-2dd3-4a6b-ac76-a12c589ea4b9",
            "name": "Dr. Antônio Gomes",
            "resourceType": {
              "id": "37ac2236-6c2d-4661-9db7-d279d956985a",
              "name": "Médico",
              "value": 3,
              "createdAt": "2021-09-16T10:51:38.616521",
              "updatedAt": "2021-09-16T10:51:38.616557"
            },
            "createdAt": "2021-09-16T11:00:44.709236",
            "updatedAt": "2021-09-16T11:47:56.641042"
          },
          "createdAt": "2021-09-16T11:47:56.640216",
          "updatedAt": "2021-09-16T11:47:56.64023"
        }
      ],
      "createdAt": "2021-09-16T11:47:56.639086",
      "updatedAt": "2021-09-16T11:47:56.63911"
    },
    {
      "id": "d80ed18a-5bfa-441f-8491-19b5e00a6b35",
      "sender": {
        "id": "589fc789-7dda-427b-92ae-1556c40ff952",
        "name": "Hospital Giselda Trigueiro",
        "address": "Rua Marcelino Vieira, 845",
        "cnpj": "4567891230",
        "latitude": 89.0,
        "longitude": 45.0,
        "occupationPercentage": 90.1,
        "occupationUpdatedAt": "2021-09-16T11:45:24.439546",
        "resources": [...],
        "createdAt": "2021-09-16T11:09:40.600005",
        "updatedAt": "2021-09-16T11:45:24.439875"
      },
      "receiver": {
        "id": "b3aa3a67-12e2-47a7-a17b-9f963fff856a",
        "name": "Hospital Walfredo Gurgel",
        "address": "Rua Mossoró, 8945",
        "cnpj": "9876543210",
        "latitude": 80.0,
        "longitude": 32.0,
        "occupationPercentage": 50.0,
        "occupationUpdatedAt": "2021-09-16T11:00:44.680174",
        "resources": [...],
        "createdAt": "2021-09-16T11:00:44.708105",
        "updatedAt": "2021-09-16T11:00:44.708129"
      },
      "exchangeResources": [],
      "createdAt": "2021-09-16T11:47:56.639619",
      "updatedAt": "2021-09-16T11:47:56.639642"
    }
  ]
}
```
