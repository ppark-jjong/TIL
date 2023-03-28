const searchForm = document.querySelector('.search-form')
const searchBox = document.querySelector('.search-input')
const searchHistory = document.querySelector('.search-history')
var searchHistoryList = ["검색기록1", "검색기록2", "검색기록3"]
var searchHistoryListIndex = 0


//검색 기록
function createSearchHistoryList(){
    if (searchHistoryListIndex<searchHistoryList.length){
        var a = document.createElement('a');
        const aText = searchHistoryList[searchHistoryListIndex];
        searchHistory.appendChild(a);
        a.outerHTML = `<a href = "http://google.com/search?q=${aText}">${aText}</a><br>`
        searchHistoryListIndex++;
        createSearchHistoryList();
    }
}
//검색한 정보를 구글창에 검색하게 한다
function searchOnGoogle(sValue) {
    location.href = 'https://google.com/search?q=${sValue}'
}

//검색하는 내용을 다루는 메서드
function handleSearch(event) {
    //이벤트의 기본기능을 없앤다
    event.preventDefault();
    //검색창에서 검색한 내용을 변수로 받는다.
    const sValue = searchBox.value;
    //검색한 내용은 구글창(친구기록)에 검색하는 함수로 넘긴다
    searchOnGoogle(sValue);
}

//검색창 메서드
function search() {
    // form 태그에서 submit라는 이벤트가 발생하면 해당 이벤트로 넘긴다
    searchForm.addEventListener("submit", handleSearch);
}


//전체 실행 메서드
function main() {
    search()
    createSearchHistoryList()
}

main()