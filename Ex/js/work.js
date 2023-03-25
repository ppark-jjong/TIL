// Get the content elements
const goalElement = document.querySelector('.goal');
const projectElement = document.querySelector('.project');
const taskElement = document.querySelector('.task');
const teamElement = document.querySelector('.team');

// Get the card list element
const cardListElement = document.querySelector('.card-list');

// Create an array of card data
const cardData = [
	{
		title: 'Goal',
		content: goalElement.textContent.trim()
	},
	{
	
