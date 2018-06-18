var submitAnswerBtn = document.getElementById("post-answer-btn");
submitAnswerBtn.addEventListener('click', function() {
    var answerArea = document.getElementById("post-answer-area");
    var answerAreaContent = answerArea.value;
    var answerContentInput = document.getElementById("post-answer-content");
    answerContentInput.value = answerAreaContent;
}, false);