
This is api doc.

---------------------------------------------
List of posts for current user:

http://localhost:8080/posts

---------------------------------------------

List of users in system:

http://localhost:8080/users

---------------------------------------------

List of posts posted by all the followed people:

http://localhost:8080/postsFromFollowedByMe

---------------------------------------------
Add new post for current user:

POST method

http://localhost:8080/addPost

Input json body:
{
  "message": "My message"
}



---------------------------------------------

Follow new user by current user:

POST method

http://localhost:8080/follow

Input json body:

{
  "name":"Bob"
}