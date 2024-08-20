const apiUrl = 'http://localhost:8081/api';

document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const username = params.get('username');
    if (username) {
        loadUserDetails(username);
    }
});

async function loadUserDetails(username) {
    try {
        const response = await fetch(`${apiUrl}/${username}`);
        if (!response.ok) throw new Error('User not found');
        const user = await response.json();
        document.getElementById('profile-picture').src = `data:image/webp;base64,${user.profilePicture}`;
        document.getElementById('username').textContent = `Username: ${user.username}`;
        document.getElementById('name').textContent = `Name: ${user.name}`;
        document.getElementById('email').textContent = `Email: ${user.email}`;
    } catch (error) {
        console.error('Error loading user details:', error);
        document.getElementById('user-details').innerHTML = '<p>User not found</p>';
    }
}

function goBack() {
    window.history.back();
}
