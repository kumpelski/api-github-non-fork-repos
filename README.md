# api-github-non-fork-repos
a Spring Boot REST API application, using <code>api.github.com</code><br>
for given GitHub username, returns a list of non-fork repos

## endpoints
*"localhost:8080" is a default address for IntelliJ IDEA*<br>
<code>GET http://localhost:8080/api/non-fork-repos/{username}</code>

## example of response
for existing user, **kumpelski**:
```json
[
  {
    "name": "api-github-non-fork-repos",
    "owner": {
      "login": "kumpelski"
    },
    "branches": [
      {
        "name": "main",
        "commit": {
          "sha": "19af63f47a91e1aa1a4703807d024feb36b6bd4d"
        }
      }
    ]
  },
  {
    "name": "volume_exe",
    "owner": {
      "login": "kumpelski"
    },
    "branches": [
      {
        "name": "main",
        "commit": {
          "sha": "d35b08fe7e1506154b96f60fce200cc9eb476361"
        }
      }
    ]
  }
]
```
for non-existing user, **niekumpelski**:
```json
{
  "status": 404,
  "message": "User not found"
}
```

## technologies
<ul>
  <li>Java 21</li>
  <li>Spring Boot 3</li>
  <ul>
    <li>Spring Web</li>
    <li>Lombok</li>
  </ul>
  <li>Maven</li>
</ul>
