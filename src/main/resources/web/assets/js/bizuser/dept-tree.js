 

// 部门树

var __AsideTree
// eslint-disable-next-line no-unused-vars
var loadDeptTree = function () {
  $.get('/admin/bizuser/dept-tree', function (res) {
    if (__AsideTree) {
      ReactDOM.unmountComponentAtNode(document.getElementById('dept-tree'))
    }

    const activeItem = __AsideTree ? __AsideTree.state.activeItem || '$ALL$' : '$ALL$'
    const data = [{ id: '$ALL$', name: $L('全部部门') }, ...res.data]
    renderRbcomp(
      <AsideTree
        data={data}
        activeItem={activeItem}
        onItemClick={(item) => {
          const depts = item.id === '$ALL$' ? [] : AsideTree.findAllChildIds(item)
          const exp = { items: [], values: {} }
          exp.items.push({ op: 'in', field: 'deptId', value: '{2}' })
          exp.values['2'] = depts
          RbListPage._RbList.search(depts.length === 0 ? {} : exp)
        }}
      />,
      'dept-tree',
      function () {
        __AsideTree = this
      }
    )
  })
}

$(document).ready(() => loadDeptTree())

RbList.renderAfter = function () {
 

  const FLAGS = {
    'WW': $L('企业微信'),
    'DD': $L('钉钉'),
  }

  const userids = []
  $('#react-list .table>tbody>tr').each(function () {
    userids.push($(this).data('id'))
  })

  $.post('/admin/bizuser/bizz-flag', userids.join(','), (res) => {
    for (let k in res.data || {}) {
      const uPrefix = res.data[k].substr(0, 2)
      const badge = `<span class="badge badge-${uPrefix}" title="${res.data[k].substr(2)}">${FLAGS[uPrefix]}</span>`
      $(`#react-list .table>tbody>tr[data-id="${k}"] td.column-empty`).html(badge)
    }
  })
}
