function setThumbnail(event) {
        var reader = new FileReader();

        reader.onload = function(event) {
            var befoimg = document.querySelector(".image");

            if(befoimg != null){
                befoimg.parentNode.removeChild(befoimg);
            }
            var li = document.createElement('li');
            var img = document.createElement('img');

            img.setAttribute('src', event.target.result);
            img.setAttribute('class', 'image');
            document.querySelector("div#image_container").appendChild(img);
        };

        reader.readAsDataURL(event.target.files[0]);
      }

const realUpload = document.querySelector('.realupload');
const upload = document.querySelector('.add-btn');

upload.addEventListener('click', () => realUpload.click());