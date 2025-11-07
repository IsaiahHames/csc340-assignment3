<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/cat-create.css">
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

    <h1>Add New Animal</h1>
    <form action="">
        <label for="">Name</label>
        <input type="text" name="Name" id="Name" placeholder="Enter animal name">

        <label for="">Breed</label>
        <input type="text" name="Breed" id="Breed" placeholder="Enter breed">

        <label for="">Date of birth</label>
        <input type="date" name="Date of Birth" id="DOB">

        <label for="">Image URL</label>
        <input type="file" name="Image URL" id="Image">

        <label for="">Description</label>
        <textarea name="Description" id="description" cols="86" rows="5" placeholder="Describe the animal"></textarea>

        <input type="submit" value="Add Animal">
    </form>
</body>
</html>