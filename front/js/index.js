const friends = [
    { name: 'Alice', age: 25, gender: 'female', interests: ['hiking', 'reading'] },
    { name: 'Bob', age: 30, gender: 'male', interests: ['travel', 'cooking'] },
    { name: 'Charlie', age: 27, gender: 'male', interests: ['music', 'photography'] },
    { name: 'Alice', age: 28, gender: 'female', interests: ['painting', 'yoga'] }
  ];
  
  function searchFriends() {
    const searchTerm = document.getElementById('friend-search-input').value.toLowerCase();
    const matchingFriends = friends.filter(friend => friend.name.toLowerCase().includes(searchTerm));
  
    const friendResultsDiv = document.getElementById('friend-results');
    friendResultsDiv.innerHTML = '';
  
    if (matchingFriends.length === 0) {
      friendResultsDiv.innerHTML = '<h2>No matching friends found</h2>';
    } else {
      friendResultsDiv.style.display = 'block';
      matchingFriends.forEach(friend => {
        const friendDiv = document.createElement('div');
        friendDiv.innerHTML = `<h2>${friend.name}, ${friend.age}</h2><p>Interests: ${friend.interests.join(', ')}</p>`;
        friendResultsDiv.appendChild(friendDiv);
      });
    }
  }
  