<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/cats-list.css">
</head>
<body>
    <header>
        <h2>BigCats</h2>
        <ul>
            <a href="index.html"><li>Home</li></a>
            <a href="details.html"><li>Details</li></a>
            <a href="about.html"><li>About</li></a>
            <a href="new-animal-form.html"><li>Add Animal</li></a>
        </ul>
    </header>

    <h1>Welcome to the BigCats Gallery</h1>

    <form action="">
        <input type="search" name="searchCat" id=searchCat" placeholder="Search by breed or name">
        <input type="submit" value="Search">
    </form>

    <div id="card_stack">
        <div class="cards">
            <img src="/pictures/lion.jpg" alt="" class="animal">
            <h3>Simba</h3>
            <p>Lion</p>
            <a href="details.html"><button>View Details</button></a>
        </div>
        <div class="cards">
            <img src="/pictures/tiger.webp" alt="" class="animal">
            <h3>Tigger</h3>
            <p>Tiger</p>
            <a href="details.html"><button>View Details</button></a>
        </div>
        <div class="cards">
            <img src="/pictures/leopard.jpg" alt="" class="animal">
            <h3>Sabor</h3>
            <p>Leopard</p>
            <a href="details.html"><button>View Details</button></a>
        </div>
        <div class="cards">
            <img src="/pictures/jaguar.avif" alt="" class="animal">
            <h3>Jade</h3>
            <p>Jaguar</p>
            <a href="details.html"><button>View Details</button></a>
        </div>
        <div class="cards">
            <img src="/pictures/mountain_lion.jpeg" alt="" class="animal">
            <h3>Louie</h3>
            <p>Mountain Lion</p>
            <a href="details.html"><button>View Details</button></a>
        </div>
        <div class="cards">
            <img src="/pictures/bobcat.jpg" alt="" class="animal">
            <h3>Bonkers</h3>
            <p>Bobcat</p>

            <a href="details.html"><button>View Details</button></a>
        </div>
    </div>
</body>
</html>