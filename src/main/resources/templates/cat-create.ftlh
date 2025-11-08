<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BigCats Create</title>
    <link rel="stylesheet" href="/css/cat-create.css">
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
    <form action="/cats" method="post" enctype="multipart/form-data">
        <label for="">Name</label>
        <input type="text" name="name" id="name" placeholder="Enter animal name"/>

        <label for="">Breed</label>
        <input type="text" name="breed" id="breed" placeholder="Enter breed"/>

        <label for="">Date of birth</label>
        <input type="date" name="dob" id="dob"/>

        <label for="">Age</label>
        <input type="number" name="age" id="age" placeholder="Enter age"/>

        <label for="">Image URL</label>
        <input type="file" name="picture" id="picture" required/>

        <label for="">Description</label>
        <input type="text" name="description" id="description" placeholder="Describe the animal"/>

        <button type="submit">Add Animal</button>
    </form>
</body>
</html>