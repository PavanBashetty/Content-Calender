fetch('http://localhost:8080/api/content')
.then(response=>{
    if(!response.ok){
        throw new Error('No response from the network' + response.statusText)
    }
    return response.json();
})
.then(data=>{

    const contentList = document.getElementById('content-list');

    data.forEach(item=>{
        const listItem = document.createElement('li');
        listItem.className = 'content-item';

        listItem.innerHTML = `
        <h3>${item.title}</h3>
        <p>${item.desc || 'No description available'}</p>
        <p>Status: ${item.status}</p>
        <p>Type: ${item.contentType}</p>
        <p>Created: ${new Date(item.dateCreated).toLocaleString()}</p>
        <p>Updated: ${item.dateUpdated ? new Date(item.dateUpdated).toLocaleString() : 'Not updated yet'}</p>
        <a href="${item.url}" target="_blank">${item.url}</a>
        `;

        contentList.appendChild(listItem);
    })
})
.catch(error=>{
    console.error('Error fetching data: ', error)
});
