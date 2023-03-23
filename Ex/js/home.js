const inviteButton = document.querySelector('#invite-button');
inviteButton.addEventListener('click', () => {
	const inviteEmail = document.querySelector('#invite-email').value;
	if (inviteEmail) {
		alert(`Invitation sent to ${inviteEmail}`);
	} else {
		alert('Please enter a valid email address');
	}
});