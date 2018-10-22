<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <form class="form-inline my-2 my-lg-0">
                <a class="navbar-brand" href="/ads">View all Listings</a>
                <%--Search bar to find ads--%>
                <input class="form-control" type="search" placeholder="Search Ads">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/ads/create">Create New Ad</a></li>
            <%--Ability to update & Delete profile--%>
            <li><a href="/">Update Profile</a></li>
            <li><a href="/">Delete Profile</a></li>
            <%--The home page goes back to their profile splashpage!--%>
            <li><a href="/profile">Home</a></li>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>