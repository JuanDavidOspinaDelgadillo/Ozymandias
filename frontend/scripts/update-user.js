const apiUrl = "http://localhost:8081/api";

document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const username = params.get('username');
    const name = params.get('name');
    const email = params.get('email');
    const password = params.get('password');

    if (username) {
        document.getElementById('username').value = username;
        document.getElementById('name').value = name;
        document.getElementById('email').value = email;
        document.getElementById('password').value = password;
    }

    document.getElementById('update-form').addEventListener('submit', event => {
        event.preventDefault();
        updateUser(username);
    });
});

async function updateUser(username) {
    const formData = new FormData();
    formData.append('username', document.getElementById('username').value);
    formData.append('name', document.getElementById('name').value);
    formData.append('email', document.getElementById('email').value);
    formData.append('password', document.getElementById('password').value);

    const profilePictureInput = document.getElementById('profile-picture');
    if (profilePictureInput.files.lenght > 0) {
        formData.append('profilePicture', profilePictureInput.files[0]);
    }

    try {
        const response = await fetch(apiUrl, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name, password })
        });

        if (response.ok) {
            alert('User updated successfully');
            window.location.href = '../index.html';
        } else {
            const errorText = await response.text();
            console.error('Error updating user:', errorText);
            alert('Error updating user');
        }
    } catch (error) {
        console.error('Error updating user:', error);
        alert('Error updating user');
    }
}

function goBack() {
    window.history.back();
}
