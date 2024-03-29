let file = document.getElementById('upload');
let button = document.getElementsByTagName('button');
let progress = document.querySelector('progress');
let PI = document.querySelector('.progress-indicator');
let load = 0;
let proces = "";

file.oninput = () => {
    let filename = file.files[0].name;
    let extension = filename.split('.').pop();
    let fileSize = file.files[0].size;

    if(fileSize <= 1000000){
        fileSize = (fileSize / 100).toFixed(2) + 'kb';
    }

    if(fileSize === 1000000 || fileSize <= 1000000000){
        fileSize = (fileSize / 1000000).toFixed(2) + 'mb';
    }

    if(fileSize === 1000000000 || fileSize <= 1000000000000){
        fileSize = (fileSize / 1000000000).toFixed(2) + 'gb';
    }

    document.querySelector('label').innerText = filename;
    document.querySelector('.ex').innerText = extension;
    document.querySelector('.size').innerText = fileSize;
    getFile(filename);
}

let upload = () => {
    if(load >= 100){
        clearInterval(proces);
        PI.innerHTML = '100%' + ' ' + 'Upload Completed';
        button[0].classList.remove('active');
    }
    else{
        load++;
        progress.value = load;
        PI.innerHTML = load  + '%' + ' ' + 'Upload ';
        button[1].onclick = e => {
            e.preventDefault();
            clearInterval(proces);
            document.querySelector('.pr').style.display = "none";
            button[1].style.visibility = 'hidden';
            button[0].classList.remove('active');
        }
    }
}

function getFile(fileName){
    if(fileName){
        document.querySelector('.pr').style.display = "block";
        load = 0;
        progress.value = 0;
        PI.innerText = '';
        button[0].onclick = e=> {
            e.preventDefault();
            button[0].classList.add('active');
            button[1].style.visibility = 'visible';
            proces = setInterval(upload, 100);
        }
    }
}