<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BigCats Details</title>
    <link rel="stylesheet" href="/css/cat-details.css">
</head>
<body>
    <header>
        <h2>BigCats</h2>
        <ul>
            <a href="/cats"><li>Home</li></a>
            <a href="/cats/createForm"><li>Add Animal</li></a>
        </ul>
    </header>

    <h1>${cat.name}</h1>

    <div>
        <img src="/pictures/${(cat.imagepath)!'basecat.png'}" alt="">
        <h3>Description:</h3>
        <p>${cat.description}</p>
        <p>Breed: ${cat.breed}</p>
        <p>Date of Birth: ${cat.dob}</p>
        <p>Age: ${cat.age}</p>

        <a href="/cats/updateForm/${cat.catId?c}"><button id="edit">Edit</button></a>
        <a href="/cats/delete/${cat.catId?c}"><button id="remove">Remove</button></a>
    </div>
    
</body>
</html>