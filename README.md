# JsonToCSV
Mini example of conversion from JSON source to write a CSV



#### Project running:
1. You need to get a file (txt by example) that represent a JSON structure. The structure is the following:
```bash
{
    "registros": [
        {
            "anexo": "1111",
            "cargo": "JobPosition1",
            "compania": "CompanyName",
            "departamento": "department",
            "email": "someEmail@domain.com",
            "fecha_inicio_licencia": "2019-06-24",
            "fecha_inicio_vacaciones": "2020-01-27",
            "fecha_termino_licencia": "2019-06-24",
            "fecha_termino_vacaciones": "2020-02-14",
            "rut": "someValue",
            "rut_jefe_directo": "someValue",
            "sucursal": "0",
            "telefono": ""
        },
        {
            "anexo": "2222",
            "cargo": "JobPosition2",
            "compania": "CompanyName",
            "departamento": "department",
            "email": "someEmail@domain.com",
            "fecha_inicio_licencia": "2019-06-24",
            "fecha_inicio_vacaciones": "2020-01-27",
            "fecha_termino_licencia": "2019-06-24",
            "fecha_termino_vacaciones": "2020-02-14",
            "rut": "someValue",
            "rut_jefe_directo": "someValue",
            "sucursal": "1",
            "telefono": ""
        }
    ]
}
```
2. Save the previous json in a text file (example: myjson.txt) and run the Spring-boot application entering the next command:       
```bash
mvn spring-boot:run -Dspring-boot.run.arguments=myjson.txt
```
3. Review on your root folder a file called employee.csv that have all the records readed from the json file. Also, the file maintains the header according the json fields structure.

![Alt text](csv_image.png?raw=true "Image")
