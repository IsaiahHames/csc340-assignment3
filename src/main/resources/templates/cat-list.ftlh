<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BigCats List</title>
    <link rel="stylesheet" href="/css/cats-list.css">
</head>
<body>
    <header>
        <h2>BigCats</h2>
        <ul>
            <a href="/cats"><li>Home</li></a>
            <a href="/cats/createForm"><li>Add Animal</li></a>
        </ul>
    </header>

    <h1>Welcome to the BigCats Gallery</h1>

    <form action="">
        <input type="search" name="searchCat" id=searchCat" placeholder="Search by breed or name">
        <input type="submit" value="Search">
    </form>

    <div id="card_stack">
        <#list catsList as cat>
        <div class="cards">
            <img src="/pictures/${(cat.imagepath)!'basecat.png'}" alt="" class="animal">
            <h3>${cat.name}</h3>
            <p>${cat.breed}</p>
            <a href="/cats/${cat.catId?c}"><button>View Details</button></a>
        </div>
        </#list>
    </div>
</body>
</html>