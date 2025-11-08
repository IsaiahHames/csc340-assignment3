<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BigCats Update</title>
    <link rel="stylesheet" href="/css/cat-update.css">
</head>
<body>
    <header>
        <h2>BigCats</h2>
        <ul>
            <a href="/cats"><li>Home</li></a>
            <a href="/cats/createForm"><li>Add Animal</li></a>
        </ul>
    </header>

    <h1>${title}</h1>
    <form action="/cats/update/${cat.catId?c}" method="post" enctype="multipart/form-data">
        <label for="">ID</label>
        <input type="text" id="catId" name="catId" value="${cat.catId?c}" readonly />

        <label for="">Name</label>
        <input type="text" name="name" id="name" value="${cat.name}" placeholder="Enter animal name"/>

        <label for="">Breed</label>
        <input type="text" name="breed" id="breed" value="${cat.breed}" placeholder="Enter breed"/>

        <label for="">Date of birth</label>
        <input type="date" name="dob" id="dob" value="${cat.dob}"/>

        <label for="">Age</label>
        <input type="number" name="age" id="age" value="${cat.age}" placeholder="Enter age"/>

        <label for="">Image URL</label>
        <input type="text" id="imagepath" name="imagepath" value="${(cat.imagepath)}" readonly />
        <input type="file" name="picture" id="picture"/>

        <label for="">Description</label>
        <input type="text" name="description" id="description" value="${cat.description}" placeholder="Describe the animal"/>

        <button type="submit">Save</button>
    </form>
</body>
</html>