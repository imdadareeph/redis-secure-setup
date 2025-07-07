const express = require('express');
const { createClient } = require('redis');

const app = express();
app.use(express.json());

const redisClient = createClient({
  url: 'redis://:YourSecurePassword@redis-master:6379'
});

redisClient.on('error', (err) => console.error('Redis Client Error', err));

(async () => {
  await redisClient.connect();

  app.get('/GET/:key', async (req, res) => {
    try {
      const val = await redisClient.get(req.params.key);
      res.json({ key: req.params.key, value: val });
    } catch (err) {
      res.status(500).json({ error: err.message });
    }
  });

  app.post('/SET/:key/:value', async (req, res) => {
    try {
      await redisClient.set(req.params.key, req.params.value);
      res.json({ key: req.params.key, value: req.params.value });
    } catch (err) {
      res.status(500).json({ error: err.message });
    }
  });

  app.listen(8080, () => {
    console.log('Redis REST API listening on port 8080');
  });
})();
