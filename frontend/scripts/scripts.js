const apiUrl = "http://localhost:8081/api";

document.addEventListener('DOMContentLoaded', () => {
    loadUsers();
    document.getElementById('user-form').addEventListener('submit', createUser);
});

async function createUser(event) {
    event.preventDefault();

    const name = document.getElementById('name').value.trim();
    const username = document.getElementById('username').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    const profilePicture = document.getElementById('profile-picture').files[0];

    if(profilePicture) {
        const imageWebp = await convertImageToWebp(profilePicture);
        const formData = new FormData();
        formData.append('name', name);
        formData.append('username', username);
        formData.append('email', email);
        formData.append('password', password)
        formData.append('profilePicture', imageWebp);

        try {
            const response = await fetch(apiUrl, {
                method: 'POST',
                body: formData
            });

            if (response.ok) {
                loadUsers();
                document.getElementById('user-form').reset();
            } else {
                console.error('Error creating user:', response.statusText);
            }
        } catch (error) {
            console.error('Error creating user:', error);
        }
    }
}

async function convertImageToWebp(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.onload = () => {
            const img = new Image();
            img.onload = () => {
                const canvas = document.createElement('canvas');
                const ctx =canvas.getContext('2d');
                canvas.width = img.width;
                canvas.height = img.height;
                ctx.drawImage(img, 0, 0);
                canvas.toBlob((blob) => {
                    resolve(blob);
                }, 'image/webp');
            };
            img.src = reader.result;
        };
        reader.onerror = reject;
        reader.readAsDataURL(file);
    });
}

async function loadUsers() {
    try {
        const response = await fetch(apiUrl);
        const users = await response.json();

        const userList = document.getElementById('users-list');
        userList.innerHTML = '';

        users.forEach(user => {
            const userItem = document.createElement('div');
            userItem.className = 'user-item';
            userItem.innerHTML = `
                <p>${user.username} - ${user.email} - ${user.name} - ${user.profilePictureId || 'N/A'}</p>
                <div class="user-buttons">
                    <button class="read-button" onclick="readUser('${user.username}')">Read</button>
                    <button class="update-button" onclick="showUpdateForm('${user.username}', '${user.name}', '${user.email}', '${user.password}')">Update</button>
                    <button class="delete-button" onclick="deleteUser('${user.username}')">Delete</button>
                </div>
            `;
            userList.appendChild(userItem);
        });
    } catch (error) {
        console.error('Error loading users:', error);
    }
}

async function deleteUser(username) {
    try {
        const response = await fetch(`${apiUrl}/${username}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            loadUsers();
        } else {
            console.error('Error deleting user:', response.statusText);
        }
    } catch (error) {
        console.error('Error deleting user:', error);
    }
}

function readUser(username) {
    window.location.href = `components/user-details.html?username=${username}`;
}

function showUpdateForm(username, name, email, password) {
    window.location.href = `components/update-user.html?username=${username}&name=${name}&password=${password}`;
}