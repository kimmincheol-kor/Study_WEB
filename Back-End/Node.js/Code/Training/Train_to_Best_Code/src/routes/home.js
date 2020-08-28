const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
    res.send('hi get');
});

router.post('/', (req, res) => {
    res.send('hi post');
});

router.put('/', (req, res) => {
    res.send('hi put');
});

router.delete('/', (req, res) => {
    res.send('hi delete');
});

module.exports = router;