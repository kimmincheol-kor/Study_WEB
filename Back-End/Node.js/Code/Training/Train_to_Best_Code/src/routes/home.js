const express = require('express');
const router = express.Router();
const controller = require('../controllers/c-home');

// External Router
const userRouter = require('./user');
const ownerRouter = require('./owner');

// Routes - Controllers Structure
router.route('/')
    .get(controller.getAPI)
    .post(controller.postAPI)
    .put(controller.putAPI)
    .delete(controller.deleteAPI)

router.use('/user', userRouter);
router.use('/owner', ownerRouter);

module.exports = router;