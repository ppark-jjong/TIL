// Add active class to the current menu item
var menuItems = document.querySelectorAll('.sidebar li a');

for (var i = 0; i < menuItems.length; i++) {
	menuItems[i].addEventListener('click', function() {
		var current = document.getElementsByClassName('active');
		current[0].className = current[0].className.replace(' active', '');
		this.className += ' active';
	});
}
