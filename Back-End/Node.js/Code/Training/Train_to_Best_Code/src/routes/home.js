const express = require('express');
const router = express.Router();
const controller = require('../controllers/c-home');

// Routes - Controllers Structure
router.route('/')
    .get(controller.getHome)
    .post(controller.postHome)
    .put(controller.putHome)
    .delete(controller.deleteHome)



// router.get('/', (req, res) => {
//     res.send('hi get');
// });

// router.post('/', (req, res) => {
//     res.send('hi post');
// });

// router.put('/', (req, res) => {
//     res.send('hi put');
// });

// router.delete('/', (req, res) => {
//     res.send('hi delete');
// });

module.exports = router;