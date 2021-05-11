export default {
    template: `
    <div>
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            <tr>
                <th>{{mydata.bnum}}</th>
                <th>{{mydata.btitle}}</th>
                <th>{{mydata.bwriter}}</th>
            </tr>
        </table>
    </div>
    `,
    data() {
        return {
            num: '',
            mydata : '',
        }
    },
    created() {
        bus.$on('aaa',this.updateLog)
    },
    methods: {
        updateLog(data) {
            this.num = data;
            alert(this.num);
            axios.get('http://182.224.88.49:9999/bootboard/board?bnum='+this.num)
            .then((resp)=>{
                console.log(resp);
                this.mydata = resp.data;
            }) 
        }
    },
}