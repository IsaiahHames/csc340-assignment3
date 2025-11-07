<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/cat-details.css">
</head>
<body>
    <header>
        <h2>BigCats</h2>
        <ul>
            <a href="/cats"><li>Home</li></a>
            <a href="details.html"><li>Details</li></a>
            <a href="about.html"><li>About</li></a>
            <a href="/cats/createForm"><li>Add Animal</li></a>
        </ul>
    </header>

    <h1>${cat.name}</h1>

    <div>
        <img src="/pictures/${cat.imagepath}" alt="">
        <h3>Description:</h3>
        <p>${cat.description}</p>
        <p>Breed: ${cat.breed}</p>
        <p>Date of Birth: ${cat.dob}</p>

        <button id="edit">Edit</button>
        <button id="remove">Remove</button>
    </div>
    
</body>
</html>