var maxCount = 5;
var count = 0;

function CountChecked(field){
	if (field.checked) {
		count += 1;
	}
	else {
		count -= 1;
	}

	if (count > maxCount) {
		alert("최대 5개까지만 선택가능합니다!");
	field.checked = false;
	count -= 1;
	}
}