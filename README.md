# ToDoListAllianz

Örnek requestleri proje içerisinde resources altında ToDoListRequests.postman_collection.json dosyasında bula bilirsiniz. Ayrıca aşağıyada koyuyorum.

http://localhost:8080/swagger-ui.html#/ link ile swagger üzerinden de açılmakta.


findAll
http://localhost:8080/jobs


Create
{
    "name": "Toplanti",
    "description": "Saat 2 de zoom toplantisi ",
    "status": "Yapilmadi"
}


Update
http://localhost:8080/jobs/1
{
    "name": "Ekmek al",
    "description": "Firina gidilip 2 ekmek alinacak",
    "status": "Yapildi."
}

findById
http://localhost:8080/jobs/1


delete
http://localhost:8080/jobs/4
