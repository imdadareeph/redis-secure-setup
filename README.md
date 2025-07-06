# Redis Master-Replica with RedisInsight (Docker Compose)

This project sets up a **Redis cache system with master-replica architecture**, **password protection**, and a **RedisInsight dashboard** using Docker Compose.

---

## Services Included

- **Redis Master** (`redis:7.2.4`)
- **Redis Replica** (`redis:7.2.4`) – read-only replica of master
- **RedisInsight** (latest) – GUI for monitoring Redis

---

## Quick Start

### 1. Clone or Create the Project

```bash
git clone https://github.com/your/repo.git
cd redis-secure-setup
```

2. Set Password in .env

## Create a .env file:
```
REDIS_PASSWORD=YourSecurePassword
```


## Start All Services
```
docker compose up -d
```

This will launch:
	•	Redis master (port 6379)
	•	Redis replica (port 6479)
	•	RedisInsight UI (port 8001)


## Install Redis CLI if needed:
```
brew install redis
```

Connect to master:
```
redis-cli -h localhost -p 6379 -a YourSecurePassword
```

## Try commands:

```
SET test "value"
GET test
```


## Access RedisInsight

Open your browser:

http://localhost:8001


📂 Folder Structure

```
redis-secure-setup/
│
├── docker-compose.yml     # Main Docker Compose setup
├── .env                   # Environment variables (passwords)
└── README.md              # Project instructions
```


Stop services:

```
docker compose down
docker compose down -v
```



## Resources
	•	Redis Official Docs
	•	RedisInsight UI
	•	Docker Compose Docs


License

```
MIT
```

```

Let me know if you'd like to add a badge, deployment button, or a GitHub Actions workflow!
```

