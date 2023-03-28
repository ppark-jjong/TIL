// Toggle the side menu bar
function toggleSidebar() {
	document.querySelector('.sidebar').classList.toggle('active');
}

// Add event listener to the menu icon
document.querySelector('.menu-icon').addEventListener('click', toggleSidebar);

// Retrieve user data from database or API
const userData = {
    name: "John Doe",
    email: "johndoe@example.com",
    role: "Administrator"
};

// Update user info in HTML
document.getElementById("user-name").innerText = userData.name;
document.getElementById("user-email").innerText = userData.email;
document.getElementById("user-role").innerText = userData.role;