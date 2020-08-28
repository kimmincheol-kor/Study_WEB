const express = require('express');
const router = express.Router();
const controller = require(`../controllers/c-owner`);

// Routes - Controllers Structure
router.route('/')
    .get(controller.getAPI)
    .post(controller.postAPI)
    .put(controller.putAPI)
    .delete(controller.deleteAPI)

module.exports = router;