/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function colors(){
    let red  = parseInt(Math.random()*255);
    let green  = parseInt(Math.random()*255);
    let blue  = parseInt(Math.random()*255);
    return `rgb(${red},${green},${blue})`
}

function linhkienChart(id, lklabels=[], lkinfo=[]){
    let color = []
    for (let i=0; i< lkinfo.length; i++)
        color.push(colors())
        
    const data = {
        labels: lklabels,
        datasets: [{
                label: 'Thong ke doanh theo san pham',
                data: lkinfo,
                backgroundColor: color,
                borderColor: color,
                hoverOffset: 4
            }]
    };


    const config = {
        type: 'bar',
        data: data,
    };
    
    let ch = document.getElementById(id).getContext("2d")
    new Chart(ch, config)
}
