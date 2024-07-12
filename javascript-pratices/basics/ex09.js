var MyObject = function(name, age) {
    this.name = name;
    this.age = age;
}

MyObject.prototype.school = "bit";
MyObject.prototype.course = "poscodx";
MyObject.prototype.info = function() {
    console.log(this.school + ":" + this.course);
}
