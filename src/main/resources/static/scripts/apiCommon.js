
function isValid(){
const form = document.getElementById('frm');
    if(!form.title.value.trim()){
        alert('제목을 입력해 주세요');
        form.title.value ='';
        form.title.focus();
        return false;
    }
    if(!form.writer.value.trim()){
            alert('작성자를 입력해 주세요');
            form.writer.value ='';
            form.writer.focus();
            return false;
    }
    if(!form.content.value.trim()){
                alert('내용을 입력해 주세요');
                form.content.value ='';
                form.content.focus();
                return false;
    }
    return true;
}
/*
function save(){
    if(!isValid()){
    return false;
    }

    const form = document.getElementById('form');
    const params ={
    title:form.title.value,
    writer: form.writer.value,
    content : form.content.value,
    deleteYn:'N'
    };

    fetch('/api/boards',{
        method :'POST',
        headers : {
            'Content-Type': 'application/json'
        },
        body : JSON.stringify(params)
    }).then(response =>{
        if (!response.ok){
            throw new Error('Request failed...');
        }

        alert('저장되었습니다.');
        location.href = '/board/list';
    }).catch(error => {
    alert('오류가 발생하였습니다.');
    })
}

