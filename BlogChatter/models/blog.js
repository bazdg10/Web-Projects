const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const blogSchema = new Schema({
    title : {
        type : String,
        required : true
    },
    snippet : {
        type : String,
        required : true
    },
    body : {
        type : String,
        required : true
    }
}, { timestamps : true });

// By default mong. pluralizes the model name and looks for the collection, eg. blog becomes blogs and is searched.
const Blog = mongoose.model('Blog', blogSchema);

module.exports = Blog;