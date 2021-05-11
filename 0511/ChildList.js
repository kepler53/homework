export default {
    template: `
    <div>
        <table border="1">
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            <tr v-for="bbb in mydata.bList">
                <td v-text="bbb.bnum"></td>
                <td><a v-bind:id="bbb.bnum" v-on:click.prevent="send($event)"  href="#" > {{bbb.btitle}} </a></td>
                <td v-text="bbb.bwriter"></td>
            </tr>
        </table>
    </div>
    `,
    data() {
        return {
            mydata: '',
        }
    },
    created() {
        axios
        .get('http://182.224.88.49:9999/bootboard/boardMain')
        .then((resp)=>{ // .then(function(resp){})
            console.log(resp);
            this.mydata = resp.data; // resp['data']
        }) 
    },
    methods: {
        send(event) {
            console.log(event.currentTarget.id);
            bus.$emit('aaa',event.currentTarget.id);
        }
        
    },
}