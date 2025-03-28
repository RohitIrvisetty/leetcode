/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    arr3 = arr1.filter((x) => arr2.indexOf(x)!=-1);
    arr5 = arr1.filter((x) => arr2.indexOf(x)==-1);
    return arr3.sort((a,b) => arr2.indexOf(a) - arr2.indexOf(b)).concat(arr5.sort((a,b) => a-b));
};